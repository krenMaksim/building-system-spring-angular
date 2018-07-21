;
(function() {
    'use strict';

    BUILDING_SYS_APP.controller("addRecordCtrl", function($scope, $controller, appService) {
        $controller("redactionRecordCtrl", {
            $scope: $scope
        });

        makeDefaultPropirties();

        $scope.$watch("responseReport[0]", function(newValue) {
            if (newValue === "New record was added") {
                makeDefaultPropirties();
            }            
        });

        $scope.safeData = function() {
            $scope.responseReport = appService.safeNewRecord($scope.updatedRecord);
        };

        function makeDefaultPropirties() {
            $scope.updatedRecord = {}; // make updatedRecord empty
            $scope.selectedDate = new Date(); // define today date

            // define avtorization user
            $scope.updatedRecord.role = $scope.user.role;
            $scope.updatedRecord.surnameInitials = $scope.user.surnameInitials;
            $scope.updatedRecord.userId = $scope.user.id;
        }
    });

}());
