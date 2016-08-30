/**
 * @param {Object} noteService the noteService which handles the communication between the controller and the API.
 * @constructor
 */
function NoteController(noteService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.editNote = editNote;
    vm.removeNote = removeNote;
    vm.submitEditedNote = submitEditedNote;
    vm.resetEditedNote = resetEditedNote;


    /**
     * Initializer. Called every time this component is created (using <note></note>).
     */
    function $onInit() {
        // vm.notesController will be our parent controller (NotesController)
        // vm.data will contain the data of this note
        vm.resetEditedNote();
    }


    /**
     * User has started to edit a note. Turn editing mode ON.
     */
    function editNote() {
        vm.isEditingNote = true;
    }


    /**
     * User has pressed 'Remove' and wants to remove this note
     */
    function removeNote() {
        noteService.destroy(vm.data.id)
            .then(vm.notesController.refreshNotes);
    }


    /**
     * User has submitted a edited note
     * @param {String} title the title of the note
     * @param {String} text the text of the note
     */
    function submitEditedNote(title, text) {
        noteService.update(vm.data.id, title, text)
            .then(vm.notesController.refreshNotes)
            .finally(vm.resetEditedNote);
    }


    /**
     * The user has stopped editing a note. Turn editing mode OFF.
     */
    function resetEditedNote() {
        vm.isEditingNote = false;
    }
}