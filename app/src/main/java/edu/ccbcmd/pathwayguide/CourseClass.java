package edu.ccbcmd.pathwayguide;


public class CourseClass {

    //These are the different types of information used by the course class.
    //This will store the title of the course
    private String title;

    //This will store the full title of the course
    private String fullTitle;
    //This will store the url to the quick register link
    private String url;
    //This will store the status of whether this course has been completed
    private boolean done;
    //This will store the status of whether this course is in progress or not.
    private boolean inProgress;
    //This will store the fact that the course has a prerequisite or not.
    private boolean anyPreReqs;
    //This will store the boolean that determines whether this particular course is open for registration
    //This will be set by a calculation.
    private boolean isOpenForRegistration;
    //This will store the name of the prerequisite course (if there is one, else it will be "NONE")
    private String preReqs;

    //This will store what position in the XML the course is
    private int position;

    //This will store if the person needs to talk to their advisor about what math they need
    private boolean meetWithAdvisor;

    //This will store if the student can get around prereq issues.
    private boolean canTakeWOPrereq;

    public CourseClass()
    {
        //Null constructor.  DO NOT use.
        super();
        title = null;
        fullTitle = null;
        url = null;
        done = false;
        inProgress = false;
        anyPreReqs = false;
        preReqs = null;
        position = -1;
        meetWithAdvisor = false;
        canTakeWOPrereq = false;
    }

    public CourseClass(String title, String fullTitle, String url, boolean done, boolean inProgress, boolean anyPreReqs, String preReqs, boolean isOpenForRegistration, int position, boolean meet, boolean jumpTheLine){
        super();
        //The proper constructor.
        this.title = title;
        this.fullTitle = fullTitle;
        this.url = url;
        this.done = done;
        this.inProgress = inProgress;
        this.anyPreReqs = anyPreReqs;
        this.preReqs = preReqs;
        this.isOpenForRegistration = isOpenForRegistration;
        this.position = position;
        this.meetWithAdvisor = meet;
        this.canTakeWOPrereq = jumpTheLine;
    }

    //The getters and setters.
    public String getTitle(){
        return title;
    }
    public String getUrl(){
        return url;
    }
    public boolean getDone(){
        return done;
    }
    public boolean getInProgress(){
        return inProgress;
    }
    public boolean getAnyPreReqs(){
        return anyPreReqs;
    }
    public String getPreReqs(){
        return preReqs;
    }
    public String getFullTitle(){return fullTitle;}
    public boolean getIsOpenForRegistration() {return isOpenForRegistration;}
    public int getPosition(){return position;}
    public boolean getMeetWithAdvisor(){return meetWithAdvisor;}
    public boolean getCanTakeWOPrereq(){return canTakeWOPrereq;}

    public void setTitle(String title){
        this.title = title;
    }
    public void setFullTitle(String title){this.fullTitle = title;}
    public void setUrl(String url){
        this.url = url;
    }
    public void setDone(boolean done){
        this.done = done;
    }
    public void setInProgress(boolean inProgress){
        this.inProgress = inProgress;
    }
    public void setAnyPreReqs(boolean anyPreReqs){
        this.anyPreReqs = anyPreReqs;
    }
    public  void setPreReqs(String preReqs){this.preReqs = preReqs; }
    public void setCanTakeWOPrereq(boolean canJump){this.canTakeWOPrereq = canJump;}

    public void setIsOpenForRegistaration(boolean is) {this.isOpenForRegistration = is;}



}
