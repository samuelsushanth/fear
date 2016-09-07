<div class="total_form" style="background-color:white;">
            <div>
                <form>
                <div class="form-group">
                 <div class="container">
                                <ul class="nav nav-tabs">
                                  <li role="presentation" class="active"><a href="#">Add</a></li>
                                  <li role="presentation"><a href="#">Choose</a></li>
                                </ul>

                  </div>
                  <div>
                    <label for="question">Enter the Question:</label>
                    <textarea class="form-control" rows="3" id="question" ng-model="vm.question"></textarea>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" >
                        <label for="choices">Enter the Choice:</label>
                    </div>
                    <div class="panel-body">
                        <ol style="background-color:white;">
                            <li style="border: 1px solid black;  width:250px; text-decoration:none;" ng-repeat="x in vm.choices">{{x}} <span ng-click="vm.removeItem($index)" style="cursor:pointer;" >x</span></li>
                        </ol>
                        <input type="text" ng-model="vm.choiceText">
                        <button ng-click="vm.choiceWasSubmitted()">submit choice</button>
                        {{vm.errortext}}
                    </div>

                </div>
                <div class="form-group">
                    <label for="choice">Enter the answer:</label>
                    <input class="form-control" ng-model="vm.answer">
                </div>
                <div style="text-align: right">
                    <button type="submit" ng-click="vm.submitQuestion()">Add</button>
                    <button type="reset" ng-click="vm.refreshF()">Reset</button>
                </div>
            </form>



            {{vm}}
        </div>
</div>