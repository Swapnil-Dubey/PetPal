package model;

// Represents an action performed with the pet
public class PetAction {
    private String petname;
    private String actionperformed;
    private String timeofaction;

    // REQUIRES: mypetname, myactionperformed, mytimeofaction have atleast one character
    // EFFECTS: sets petname to mypetname, timeofaction to mytimeofaction, actionperformed to myactionperformed
    public PetAction(String mypetname, String myactionperformed, String mytimeofaction) {
        this.petname = mypetname;
        this.timeofaction = mytimeofaction;
        this.actionperformed = myactionperformed;
    }

    public String getTimeOfAction() {
        return timeofaction;
    }

    public void setTimeofaction(String timeofaction) {
        this.timeofaction = timeofaction;
    }

    public String getActionPerformed() {
        return actionperformed;
    }

    public void setActionperformed(String actionperformed) {
        this.actionperformed = actionperformed;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }
}
