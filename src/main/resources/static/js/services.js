angular.module('companyApp.services',[]).factory('Company',function($resource){
    return $resource('/companies/:id',{id:'@companyId'},{
        update: {
            method: 'PUT',
            isArray: false,
            headers: { 'Content-Type': 'application/json; charset=UTF-8' }
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});