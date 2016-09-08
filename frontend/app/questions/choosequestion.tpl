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
                          <option value="option-1">Choice 1</option>
                          <option value="option-2">Choice 2</option>
                          <option value="option-3">Choice 3</option>
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