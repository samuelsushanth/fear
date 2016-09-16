
angular.module('app', ["ngRoute"])
    .factory("choiceService", choiceService)
    .factory("examsService", examsService)
    .config(config)
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
        templateUrl: 'app/old_questions/add-questions.tpl',
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
    })
    .component('questions',{
        templateUrl: 'app/questions/addquestions.tpl',
        controller: QuestionsController,
        controllerAs: 'vm',

        bindings:{
            examId:'@'
        }
    })