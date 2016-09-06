
angular.module('app', ["ngRoute"])
    .config(config)
    .factory('noteService', noteService)
    .factory("choiceService", choiceService)
    .component('noteForm', {
        templateUrl: 'app/note-form/note-form.tpl',
        controller: NoteFormController,
        controllerAs: 'vm',

        require: {
            notesController: '^notes'
        },

        bindings: {
            data: '<',
            onSubmit: '<',
            onReset: '<'
        }
    })
    .component('notes', {
        templateUrl: 'app/notes/notes.tpl',
        controller: NotesController,
        controllerAs: 'vm'
    })
    .component('note', {
        templateUrl: 'app/note/note.tpl',
        controller: NoteController,
        controllerAs: 'vm',

        require: {
            notesController: '^notes'
        },

        bindings: {
            data: '<'
        }
    })
    // choiceForm becomes <choice-form> in HTML
    .component('choiceForm', {
        templateUrl: 'app/choice-form/choice-form.tpl',
        controller: ChoiceFormController,
        controllerAs: 'vm',

        bindings: {
            name: '@',
            test: '@'
        }
    });