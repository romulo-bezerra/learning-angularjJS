angular.module("listaTelefonica").factory("contatosAPI", function ($http, config) {
    var _getContatos = function () {
        return $http({method: 'get', url: config.baseUrl + 'contato'});
    };

    var _saveContato = function (contato) {
        return $http({method: "post", url: config.baseUrl + 'contato', data: contato});
    };
    
    var _removeContatos = function (contato) {
        return $http({method: "delete", url: config.baseUrl + 'contato/' + contato.id});
    };
    
    return {
        getContatos: _getContatos,
        saveContato: _saveContato,
        removeContatos: _removeContatos
    };

});