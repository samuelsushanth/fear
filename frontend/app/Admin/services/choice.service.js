
function choiceService($http, $interpolate) {
    /**
     * This is the base URL to our API in the backend.
     * @type {String}
     */
    //var toListURL = 'http://localhost:8080/api/exam/'+$route.current.params.eexamId+'/question/'+$route.current.params.questionId+'/choice';
    var toListURL = $interpolate('/api/exam/{{examId}}/question/{{questionId}}/choice');
    /**
     * This is the detail URL to our API in the backend. It handles requests with path parameters.
     * E.g. /api/note/5/
     * @type {Function}
     */
    var toDetailURL = $interpolate('localhost:8080/api/exam/1/question/1/choice');


    return {
        list: list,
        create: create
    };

    /**
     * Sends a GET request to the API.
     * @returns {Object}
     */
    function list(examId, questionId) {
        return $http.get(toListURL({examId : examId, questionId : questionId}));
    }

    /**
     * Sends a POST request to the API
     * @returns {Object}
     */
    function create(text) {
        return $http.post(toListURL, { text: text });
    }

}