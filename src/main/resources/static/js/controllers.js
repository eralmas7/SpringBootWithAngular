angular.module('companyApp.controllers',[]).controller('CompanyListController',function($scope,$state,popupService,$window,Company){
    $scope.companies=Company.query();
    $scope.deleteCompany=function(company){
        if(popupService.showPopup('Really delete this?')){
        	company.$delete(function(company){
                $window.location.href='';
            });
        }
    }
}).controller('CompanyViewController',function($scope,$stateParams,Company){
    $scope.company=Company.get({id:$stateParams.id});
}).controller('CompanyCreateController',function($scope,$state,Company){

    $scope.company=new Company();
    $scope.addCompany=function(){
    	$scope.company.beneficiaries = $scope.company.beneficiaries.beneficiaryList;
        $scope.company.$save(function(){
            $state.go('companies');
        });
    }
}).controller('CompanyEditController',function($scope,$state,$stateParams,Company){
    $scope.updateCompany=function(){
    	$scope.company.beneficiaries = $scope.company.beneficiaries.beneficiaryList;
        $scope.company.$update(function(){
            $state.go('companies');
        });
    };
    $scope.loadCompany=function(){
        $scope.company=Company.get({id:$stateParams.id});
    };
    $scope.loadCompany();
}).controller("CompanyBeneficiaryController", function($scope){
	   $scope.company.beneficiaries ={
	       beneficiaryList:[{ name:""}]
	   };
	  $scope.addRow = function(index){
	    var name = {name:""};
	       if($scope.company.beneficiaries.beneficiaryList.length <= index+1){
	            $scope.company.beneficiaries.beneficiaryList.splice(index+1,0,name);
	        }
	    };
	  $scope.deleteRow = function($event, index){
		  if ($event.which == 1) {
			  $scope.company.beneficiaries.beneficiaryList.splice(index,1);
		  }
	    }
});