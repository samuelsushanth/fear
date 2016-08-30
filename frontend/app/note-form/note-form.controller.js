/**
 * @param {Object} noteService the noteService which handles the communication between the controller and the API.
 * @constructor
 */
function NoteFormController(noteService) {
    var vm = this;
    vm = this.choices;

    vm.$onInit = $onInit;

    /**
     * If a parent controller has provided a on-submit attribute, then we use it. Otherwise, use defaultSubmitForm
     * @example <note-form on-submit="doSomething()"></note-form>
     * @type {Function}
     */
    vm.onSubmit = vm.onSubmit || defaultSubmitForm;

    /**
     * If a parent controller has provided a on-reset attribute, then we use it. Otherwise, use defaultResetForm
     * @example <note-form on-reset="doSomething()"></note-form>
     * @type {Function}
     */
    vm.onReset  = vm.onReset || defaultResetForm;


    /**
     * Initializer. Called every time this component is created (using <note-form></note-form>).
     */
    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.title = parentControllerHasSetData ? vm.data.title : '';
        vm.text  = parentControllerHasSetData ? vm.data.text  : '';
    }


    /**
     * The default function for when the user presses 'Submit'. The default behaviour
     * for a form is to create a new note using the API.
     * @param {String} title
     * @param {String} text
     */
    function defaultSubmitForm(title, text) {
        var count = 2;
        vm.choices=["ch1", "ch2"];
        if (!title) {return;}
        if (vm.choices.indexOf(title) == -1) {
            vm.choices.push(title);
            count++;
            alert(vm.choices);
        } else {
            vm.errortext = "The choice is already in your list.";
        }
        vm.removeItem = function (x) {
            vm.errortext = "";
            vm.choices.splice(x, 1);
            count++;
        }


    }


    /**
     * The default behaviour resets the note to its starting state. Meaning, we clear all the fields from data.
     */
    function defaultResetForm() {
        vm.title = '';
        vm.text = '';
        vm.noteForm.$setPristine();
        vm.noteForm.$setUntouched();
    }
}