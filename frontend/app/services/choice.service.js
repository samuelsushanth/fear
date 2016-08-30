function choiceService($q) {
    return {
        list: list
    };

    function list() {
        //return $http.get('url to where all my choices are...');
        return $q.resolve({ data: [
          { id: 1, text: 'i am choice 1' },
          { id: 2, text: 'i am choice 2' }
        ] });
    }
}