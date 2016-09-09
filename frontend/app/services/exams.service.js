function examService($http, $interpolate) {
    /**
     * This is the base URL to our API in the backend.
     * @type {String}
     */
    var toListURL = '/exam';

    /**
     * This is the detail URL to our API in the backend. It handles requests with path parameters.
     * E.g. /api/note/5/
     * @type {Function}
     */
    var toDetailURL = $interpolate('/api/note/{{id}}/');


    return {
        list: list,
        create: create

    };

    /**
     * Sends a GET request to the API.
     * @returns {Object}
     */
    function list() {
        return $http.get(toListURL);
    }

    /**
     * Sends a POST request to the API
     * @returns {Object}
     */
    function create(text) {
        return $http.post(toListURL, { text: text });
    }

}