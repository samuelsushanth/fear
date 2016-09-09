
angular.module('app', ["ngRoute"])
    .config(config)
    .factory('noteService', noteService)
    .factory("choiceService", choiceService)
    .factory("examsService", examsService)
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
    //choosing the old_questions form
    .component('choosequestion', {
    templateUrl: 'app/old_questions/choosequestion.tpl',
    controller: ChooseQuestion,
    controllerAs: 'am',

    bindings: {
        data: '@'
    }
    })
    // addquestionForm becomes <old_questions> in HTML
    .component('addquestion', {
        templateUrl: 'app/old_questions/add-question.tpl',
        controller: ChoiceFormController,
        controllerAs: 'vm',

        bindings: {
            name: '@',
            test: '@'
        }
    })
    .component('exams', {
        templateUrl: 'app/exams/exams.tpl',
        controller: ExamsController,
        controllerAs: 'vm'
    });