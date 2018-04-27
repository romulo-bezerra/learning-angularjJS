angular.module("listaTelefonica").factory("operadorasAPI", function ($http, config) {
    var _getOperadoras = function () {
        return $http({method: 'get', url: config.baseUrl + 'operadora'});
    };

    return {
        getOperadoras: _getOperadoras
    };

});