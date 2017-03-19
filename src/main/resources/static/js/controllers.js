/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */


class ParentController {
	constructor(){
		this.label = {};
	}
	
	loadLabel(page,language){
		this._mainService.getLabel(page,language)
		.then(
				(data) => {
					this.label = data;
				},
				(data) => {
					console.log(data);
				}
		);
	}

}

class MainController extends ParentController {
	constructor(mainService, $window, $uibModal) {
		"ngInject";
		super();
		//this._userService = userService;

		this._mainService = mainService;
		this._$window = $window;
		this._$uibModal = $uibModal;

		

		this.loadLabel('landingpage','th');
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

