/*function choiceService($http, $interpolate) {

    /!**
     * This is the detail URL to our API in the backend. It handles requests with path parameters.
     * E.g. /api/note/5/
     * @type {Function}
     *!/
    var toDetailURL = $interpolate('/api/note/{{id}}/');*/
function choiceService($q,$http) {
    /**
     * This is the base URL to our API in the backend.
     * @type {String}
     */
    var toListURL   = '/api/note/';


    return {
        list: list,
        create: create,
    };

    function create(question, choices, answer) {
        return $http.post(toListURL, { question: question, choices: choices, answer: answer});
    }

    function list() {
        //return $http.get('url to where all my choices are...');
        return $q.resolve({ data: [
          { id: 1, text: 'i am choice 1' },
          { id: 2, text: 'i am choice 2' }
        ] });
    }
}





