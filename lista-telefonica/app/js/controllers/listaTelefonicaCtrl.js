angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI) {
    $scope.app = "Lista Telefonica";
    $scope.contatos = [];
    $scope.operadoras = [];
    //            $scope.contatos = [
    //                {nome: $filter('uppercase')("Pedro"), telefone: "999999999", data: new Date(), operadora: {nome: "Oi", codigo: 14}},
    //                {nome: "Ana", telefone: "888888888", data: new Date(), operadora: {nome: "Oi", codigo: 14}},
    //                {nome: "Maria", telefone: "777777777", data: new Date(), operadora: {nome: "Oi", codigo: 14}}
    //            ];
//                $scope.operadoras = [
//                    {nome: "Oi", codigo: 14, categoria: "Celular"},
//                    {nome: "Vivo", codigo: 15, categoria: "Celular"},
//                    {nome: "Tim", codigo: 41, categoria: "Celular"},
//                    {nome: "GVT", codigo: 25, categoria: "Fixo"},
//                    {nome: "Embratel", codigo: 21, categoria: "Fixo"}
//                ];

    var carregarContatos = function () {
        contatosAPI.getContatos().then(function (response) {
            data = response.data;
            $scope.contatos = data;
        }, function (error) {
            $scope.error = "Não foi possível carregar os dados!";
            console.log(error, 'Não foi possível obter os dados');
        });
    };

    var carregarOperadoras = function () {
        operadorasAPI.getOperadoras().then(function (response) {
            data = response.data;
            $scope.operadoras = data;
        }, function (error) {
            console.log(error, 'Não foi possível obter os dados');
        });
    };

    $scope.addContato = function (contato) {
        //console.log($scope.nome);
        //$scope.contatos.push({nome: $scope.nome, telefone: $scope.telefone}); //Forma ruim de passar parâmetro; quebra o mantra: deve-se evitar ler o $scope estando dentro do controller
        //$scope.contatos.push({nome: nome, telefone: telefone}); //Forma media, ainda não esta boa: muita burocracia.
        //$scope.contatos.push(contato); //Forma O.O -> mais simples. Porém essa forma ainda permanece referenciada na view. Precisamos fazer uma copia para se quisermos que não fique referenciada e editável
//                    $scope.contatos.push(angular.copy(contato));
//                    delete $scope.contato;
//                    $scope.contatoForm.$setPristine();
        contato.data = new Date();
        contatosAPI.saveContato(contato).then(function (response) {
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
            $scope.contatos.push(angular.copy(response.data));
        }, function (error) {
            console.log(error, 'Não foi possível salvar os dados');
        });
    };

//                $scope.apagarContatos = function (contatos) {
//                    $scope.contatos = contatos.filter(function (contato) {
//                        if (!contato.selecionado)
//                            return contato;
//                    });
//                };

    $scope.apagarContatos = function (contatos) {
        $scope.contatos = contatos.filter(function (contato) {
            if (contato.selecionado) {
                contatosAPI.removeContatos(contato).then(function (response) {
                    carregarContatos();
                }, function (error) {
                    console.log(error, 'Não foi possível excluir os dados');
                });
            }
            ;
        });
    };

    $scope.isContatosSelecionados = function (contatos) {
        return contatos.some(function (contato) {
            return contato.selecionado;
        });
//                    console.log(isContatoSelecionado);
    };
    $scope.ordenarPor = function (campo) {
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };
    carregarContatos();
    carregarOperadoras();
});
