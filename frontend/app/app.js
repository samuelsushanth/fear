
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
    //choosing the questions form
    .component('choosequestion', {
    templateUrl: 'app/questions/choosequestion.tpl',
    controller: ChooseQuestion,
    controllerAs: 'am',

    bindings: {
        data: '@'
    }
    })
    // addquestionForm becomes <questions> in HTML
    .component('addquestion', {
        templateUrl: 'app/questions/add-question.tpl',
        controller: ChoiceFormController,
        controllerAs: 'vm',

        bindings: {
            name: '@',
            test: '@'
        }
    });