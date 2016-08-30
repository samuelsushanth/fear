/**
 * @param {Object} noteService the noteService which handles the communication between the controller and the API.
 * @constructor
 */
function NotesController(noteService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.refreshNotes = refreshNotes;
    vm.hasNotes = hasNotes;


    /**
     * Initializer. Called every time this component is created (using <notes></notes>).
     */
    function $onInit() {
        vm.notes = [];
        vm.refreshNotes();
    }


    /**
     * Refreshes all notes
     * @returns {Object}
     */
    function refreshNotes() {
        return noteService.list().then(function refreshedNotes(response) {
            vm.notes = response.data;
        });
    }


    /**
     * Checks if there are any notes available.
     * @returns {boolean}
     */
    function hasNotes() {
        return vm.notes.length > 0;
    }
}