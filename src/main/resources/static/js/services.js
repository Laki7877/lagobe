/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */

function mainService(PAGE, $q, $window, $http){
    "ngInject";
    
    return {
        signin,
        create,
        update,
        isLoggedIn,
        getLabel
    };
    
    function signin(username, password){
        let deferred = $q.defer();
                                        
        $window.localStorage.userInfo = {
            "email": "string",
            "firstName": "string",
            "lastName": "string",
            "password": "string",
            "userId": 0
        };
                                        
        deferred.resolve();
//        this._$http.post(this._MainAppConstant.apiPath+'/authenticate', { username, password }).then(
//            (respond) => {
//                this.localStorage.token = respond.data.token;
//                this.localStorage.isLoggedOut = "0";
//                
//                deferred.resolve();
//            },
//            (reason) => {
//                delete this.localStorage.token;
//                delete this.localStorage.isLoggedOut;
//                
//                deferred.reject(reason.data);
//            }
//        );
        return deferred.promise;
    }
    
    function create() {
        
    }
    
    function update() {
        
    }
    
    function isLoggedIn() {
        return $window.localStorage.userInfo != null;
    }
    
    function getLabel(page,language){
        let _language;
        if(!language){
            if($window.localStorage.lang) {
                _language = $window.localStorage.lang;
            }
            else{
                _language = PAGE.LANGUAGE;
            }
        }
        else{
            _language = language;
        }
        $window.localStorage.lang = _language;

    	var promise = $http.get('languages/'+page+'/'+_language+'.json').then(function(response){
    		return response.data;
    	});
    	return promise;
    }
    
}

function userService(){
    "ngInject";
    
    return {
        signin
    };
    
    function signin(username, password){
        alert(username+" "+password);
    }
}

angular.module('MainApp')
.factory('mainService', mainService);

angular.module('User')
.factory('ีuserService', userService);
