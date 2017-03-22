/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */

function mainService(PAGE, $q, $window, $http){
    "ngInject";
    
    return {
        signin,
        signUp,
        create,
        update,
        isLoggedIn,
        getLabel
    };
    
    function signin(username, password){
        let deferred = $q.defer();
        $http.post('/login', { username, password }).then(
            (respond) => {
                $window.localStorage.userInfo = respond.data;

                deferred.resolve(respond.data);
            },
            (reason) => {
                deferred.reject(reason.data);
            }
        );
        return deferred.promise;
    }
    
    function signUp(user) {
    	let deferred = $q.defer();
    	$http.put('/user',user,[]).then(
    			(respond) => {
		    		deferred.resolve(respond.data);
    			},
    			(reason) => {
    				deferred.reject(reason.data);
    			}
    		);
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

function userService($http,$q){
    "ngInject";
    
    return {
        signin,
        getCompanies,
        getBanks
    };
    
    function getBanks() {
    	let deferred = $q.defer();
    	$http.get('/staticdata/banks').then(
    			(respond) => {
		    		deferred.resolve(respond.data);
    			},
    			(reason) => {
    				deferred.reject(reason.data);
    			}
    		);
    	return deferred.promise;
    }
    
    function getCompanies() {
    	let deferred = $q.defer();
    	$http.get('/staticdata/companies').then(
    			(respond) => {
		    		deferred.resolve(respond.data);
    			},
    			(reason) => {
    				deferred.reject(reason.data);
    			}
    		);
    	return deferred.promise;
    }
    
    function signin(username, password){
        alert(username+" "+password);
    }
}

angular.module('MainApp')
.factory('mainService', mainService);

angular.module('User')
.factory('userService', userService);
