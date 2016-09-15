<div class="panel panel-default" class="col-xs-1">
    <div class="panel-heading" style="background-color: lightgray;">
        <input type="text" ng-model="vm.choiceText" placeholder="Enter the choice">
        <button ng-click="vm.choices()"> +choice</button>
        <ol>
            <li style="border: 1px solid black;  width:250px; text-decoration:none;" ng-repeat="x in vm.choices">{{x}} <span ng-click="vm.removeItem($index)" style="cursor:pointer;" >x</span></li>
        </ol>
    </div>
    {{vm.errortext}}
</div>

</div>