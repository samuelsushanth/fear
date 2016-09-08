<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<form name="vm.noteForm" ng-submit="vm.onSubmit(vm.title, vm.text)" class="panel panel-default">
      <ul>
                    <li ng-repeat="x in this.choices" ng-bind="x"></li>
                </ul>
   <div class="panel-body">

        <div class="form-group">
            <label for="text">Enter the Question</label>
            <textarea id="text" name="text" class="form-control" ng-model="vm.text" placeholder="Enter Question here ..." required></textarea>
        </div>
    </div>


</form>