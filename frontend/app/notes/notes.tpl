<div class="container">
    <div class="row">
        <h4 class="col-xs-12 page-header">Questions</h4>
    </div>

    <div class="row">
        <note-form class="col-xs-12"></note-form>


    </div>

    <div class="row">
        <note class="col-xs-6" ng-repeat="note in vm.notes" data="note"></note>
    </div>
</div>