package Page;

import common.BaseControl;
import common.SoftAssertion;
import org.openqa.selenium.WebDriver;


public class EditPage extends PageBase {
    private BaseControl firstNameInput = new BaseControl("xpath = //*[@id=\"modal_first_name\"]");
    private BaseControl lastNameInput = new BaseControl("xpath = //*[@id=\"modal_last_name\"]");
    private BaseControl updateBtn = new BaseControl("xpath = //*[@id=\"root\"]/div[2]/div[1]/div/div/button");

    private BaseControl successPopup = new BaseControl("class = _2NfeO");
    private BaseControl myLearningBtn = new BaseControl("xpath = //*[@id=\"navigation\"]/a[1]");

    public EditPage(WebDriver driver) {
        super(driver);

    }


    public void inputName()   {
        firstNameInput.enter("Team");
        lastNameInput.enter("six");

    }
    public void updateBtnClick() {
        updateBtn.click();
    }
    public void verifySuccessPop() {

        String text = successPopup.getText();
        SoftAssertion.assertEqual(text,"Profile updated successfully","Verify Change Name Successfully");
    }
    public void myLearnningClick() {
        myLearningBtn.click();
    }
}
