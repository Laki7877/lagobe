/**
 * Created By: Laki Sik
 * Email: mr.laki.sik@gmail.com
 * Phone: +66874414008
 */


class ParentController {
	constructor($window){
        this._$window = $window;
		this.label = {};
	}
	
	loadLabel(page,language){
		this._mainService.getLabel(page, language)
		    .then(
		        (data) => {
		            this.label = data;
		        }, (data) => {
		            console.log(data);
		        }
		    );
	}

    switchLanguage(page) {
        let languageOld = this._$window.localStorage.lang;
        let languageNew;

        if(languageOld == "en") {
            languageNew = "th";
        }
        else if(languageOld == "th") {
            languageNew = "en"
        }
        this.loadLabel(page, languageNew);
    }

}

class MainController extends ParentController {
	constructor(mainService, $window, $uibModal, $location) {
		"ngInject";
		super();
		//this._userService = userService;

		this._mainService = mainService;
		this._$window = $window;
		this._$uibModal = $uibModal;
		this._$location = $location;

		this.loadLabel('landingpage');
		this.form = {};
	}

	viewContract() {
        this._$uibModal.open({
			template: '<a embed-pdf href="http://sc.lagobe.com/assets/docs/Lagobe_MPA_2017_Digital.pdf" class="embed"></a>',
			size: 'lg',
			backdrop: true,
			windowTopClass: 'modal-contract'
		});
	}

	signin() {
        this._mainService.signin(this.user.username, this.user.password)
            .then(
                (data) => {
                    this._$window.location.href = "/signup";
                },
                (error) => {
                    //this.error.signin = true;
                    this.user.password = "";
                }
            );
    }

	signUp() {
    	console.log(this.form);
    	this._mainService.signUp(this.form)
    		.then(
    			(data) => {
    				this._$window.localStorage.user = JSON.stringify(data);
		    		this.form = {};
		    		this._$location.path( '/signup');
    			},
    			(error) => {
    				alert(error.message);
    			}
    		);
	}

	
}

class UserController{
	constructor($scope, $window, $location, userService) {
		"ngInject";
		
        this._$scope = $scope;
        this._$window = $window;
        this._$location = $location;
        this._userService = userService;
        
        this._userService.getCompanies()
        	.then(
    			(data) => {
    				this.companies = data;
    			},
    			(error) => {
    				alert(error.message);
    			}
    		);
        this._userService.getBanks().then(
    			(data) => {
    				this.banks = data;
    			},
    			(error) => {
    				alert(error.message);
    			}
    		);
        
        if(!this._$window.localStorage.user){
        	this._$location.path( '/');
        }
        
        this._userStorage = JSON.parse(this._$window.localStorage.user);

        this.signOnbehalfOfSwitch = "individual";

        this.signupInfo = {
            store: {
                storeName: "",
                signOnBehalfOf: "",
                individual: {
                    register: {
                        firstName: "",
                        lastName: "",
                        citizenID: "",
                        phone: "",
                        lineID: "",
                        email: "",
                        facebook: ""
                    },
                    isContactSameRegister: false,
                    contact: {
                        firstName: "",
                        lastName: "",
                        citizenID: "",
                        phone: "",
                        lineID: "",
                        email: "",
                        facebook: ""
                    },
                    document: {
                        citizenCard: null,
                        homeRegister: null
                    }
                },
                company: {
                    register: {
                        companyPrefix: "",
                        companyName: "",
                        taxID: "",
                        phone: "",
                        lineID: "",
                        email: "",
                        facebook: ""
                    },
                    contact: {
                        firstName: "",
                        lastName: "",
                        citizenID: "",
                        phone: "",
                        lineID: "",
                        email: "",
                        facebook: ""
                    },
                    document: {
                        companyCertificate: null,
                        tradeRegister: null
                    }
                }
            },
            bank: {
                bankName: "",
                bankBranch: "",
                accountNumber: "",
                accountType: "",
                accountName: ""
            },
            address: {
                pickup: {
                    zipCode: "",
                    province: "",
                    amphur: "",
                    tumbon: "",
                    other: ""
                },
                isDocumentDropSamePickup: false,
                documentDrop: {
                    zipCode: "",
                    province: "",
                    amphur: "",
                    tumbon: "",
                    other: ""
                }
            }
        };
        this.signupInfo.store.individual.register.firstName = this._userStorage.firstName;
        this.signupInfo.store.individual.register.lastName = this._userStorage.lastName;
        this.signupInfo.store.individual.register.phone = this._userStorage.phone;
        this.signupInfo.store.individual.register.email = this._userStorage.email;
        
	}
	
	save() {
		console.log(this.signupInfo.store.company.register.companyPrefix);
	}

    updateStoreIndividualContactValues() {
        if(this.signupInfo.store.individual.isContactSameRegister){
            $.each(this.signupInfo.store.individual.contact, (field, value) => {
                this.signupInfo.store.individual.contact[field] = this.signupInfo.store.individual.register[field];
            });
        }
    }

    updateAddressDocumentDropValues() {
        if(this.signupInfo.address.isDocumentDropSamePickup){
            $.each(this.signupInfo.address.documentDrop, (field, value) => {
                this.signupInfo.address.documentDrop[field] = this.signupInfo.address.pickup[field];
            });
        }
    }
    
    
}

angular.module('MainApp')
.controller('MainController', MainController);

angular.module('User')
.controller('UserController', UserController);

