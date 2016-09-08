<div class="total_form" style="background-color:white;">
            <div>
                <form>
                <div class="form-group">
                  <div>

                    <div ng-controller="choose-tab.controller">
                      <form name="myForm">

                        <hr>
                        <label for="multipleSelect">List of questions: </label><br>
                        <select name="multipleSelect" id="multipleSelect" ng-model="data.multipleSelect" multiple>
                            <ol style="background-color:white;">
                                <li style="border: 1px solid black;  width:250px; text-decoration:none;" ng-repeat="x in vm.db_questions">{{x}}</li>
                            </ol>
                        </select><br>
                        multipleSelect = {{data.multipleSelect}}<br/>
                      </form>
                    </div>
                    </div>
                </div>


                <div style="text-align: right">
                    <button type="submit" ng-click="vm.createExam()">add</button>

                </div>
            </form>



            {{vm}}
        </div>
</div>