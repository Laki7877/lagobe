/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */

class MainController{
    constructor(mainService, $window, $uibModal) {
        "ngInject";
        
        //this._userService = userService;
        
        this._mainService = mainService;
        this._$window = $window;
        this._$uibModal = $uibModal;
    }
    
    viewContract() {
        this._$uibModal.open({
            template: '<iframe src="assets/docs/Lagobe_MPA_2017_Digital.pdf" width="100%" height="100%"></iframe>',
            size: 'lg',
            backdrop: true,
            windowTopClass: 'modal-contract'
        });
    }
    
    signin() {
        this._mainService.signin(this.user.username, this.user.password)
            .then(
            () => {
                this._$window.location.reload();
            },
            (data) => {
                //this.error.signin = true;
                this.user.password = "";
            }
        );
    }
}

class UserController{
    constructor() {
        "ngInject";
        
    }
}

angular.module('MainApp')
.controller('MainController', MainController);

angular.module('User')
.controller('UserController', UserController);

