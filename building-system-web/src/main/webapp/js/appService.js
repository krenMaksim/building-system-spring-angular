;
(function() {
    'use strict';

    BUILDING_SYS_APP.service('appService', ['$http', function($http) {

        this.makeStringFromDate = function(date) {
            let yyyy = date.getFullYear();
            let mm = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1);
            let dd = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            return yyyy + '-' + mm + '-' + dd;
        };

        this.isDateBelongedInterval = function(dateStr, dateWith, dateOn) {
            let date = new Date(dateStr);
            date.setHours(0);

            if (date < dateWith) {
                return false;
            }

            if (dateOn === null || dateOn === undefined) {
                return true;
            } else if (date > dateOn) {
                return false;
            }
            return true;
        };

        this.isSurnameBelongedInterval = function(surname, set) {
            if (set.size === 0) {
                return true;
            }

            if (set.has(surname)) {
                return true;
            } else {
                return false;
            }
        };

        this.safeNewRecord = function(newRecord) {
            return makePutRequest(AJAX_URL.NEW_RECORD_REST, newRecord);
        };

        this.safeUpdatedRecord = function(updatedRecord) {
            return makePutRequest(AJAX_URL.REDACTION_RECORD_REST, updatedRecord);
        };

        this.getSmetaMap = function() {
            let map = new Map();
            $http.get(AJAX_URL.SMETA_REST).then(function(response) {
                let smetaArray = response.data;

                for (var i = 0; i < smetaArray.length; i++) {
                    map.set(smetaArray[i].id + '', smetaArray[i]);
                }
            });
            return map;
        };

        this.getSmetaRecords = function() {
            return makeGetRequest(AJAX_URL.SMETA_REST);
        };

        this.getMagazineRecords = function() {
            return makeGetRequest(AJAX_URL.MAGAZINE_REST);
        };

        this.getUserRecords = function() {
            return makeGetRequest(AJAX_URL.USER_REST);
        };

        this.getValidUser = function() {
            return makeGetRequest(AJAX_URL.VALID_USER_REST);
        };

        function makeGetRequest(url) {
            let tagetObject = {};

            $http.get(url).then(function(response) {
                Object.assign(tagetObject, response.data);
            });

            return tagetObject;
        }

        function makePutRequest(url, dataObject) {
            let responseObject = {};

            $http.post(url, dataObject).then(function(response) {
                Object.assign(responseObject, response.data);
            });

            return responseObject;
        }

    }]);
}());
