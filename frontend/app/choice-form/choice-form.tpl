
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><div class="center">
            <p>Online Exam</p>
        </div></div>
        <div class="panel-body">
            <ul data-spy="affix" data-offset-top="25">
                <li style="float: left;"><a href="index.html">Home</a></li>
                <li style="float: left;"><a class="active" href="#" style="text-decoration: none">Questions</a></li>
                <li style="float: left;"><a href="questionaire.html">Questionnaire</a></li>
                <li style="float:right"><a href="#">Log out</a></li>
            </ul>
            <div><form>
                <div class="form-group">
                    <label for="question">Enter the Question:</label>
                    <textarea class="form-control" rows="3" id="question" ng-model="vm.question"></textarea>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Enter the choices:</h3>
                    </div>
                    <div class="panel-body">
                        <ol style="background-color:  white;">
                            <li style="border: 1px solid black;  width:250px; text-decoration: none" ng-repeat="x in vm.choices">{{x}} <span ng-click="vm.removeItem($index)" style="cursor:pointer;" >x</span></li>
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
            </div>
            {{vm}}
        </div>
    </div>
</div>
<div class="footer">
    CopyRights
</div>