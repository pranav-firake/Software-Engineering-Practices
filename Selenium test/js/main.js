var TwitterUser = function(username,userID,timeago,mypic, tweetmsg, contentpic,retweet,likes) {
    this.username = username;
    this.userID=userID;
    this.timeago=timeago;
    this.mypic = mypic;
    this.tweetmsg = tweetmsg;
   this.shouldShowPic=false;
    this.contentpic = contentpic;
   if(this.contentpic!=""){ this.shouldShowPic=true;}
    this.retweet=retweet;
    this.likes=likes;
}
var custompic="img/pushkar.png";
var customusername="Pushkar";
var customuserID="@pLadhe";
var customtimeago="Just Now";
var users=new Array();


// The view model is an abstract description of the state of the UI, but without any knowledge of the UI technology (HTML)
var viewModel = {
	//users: ko.observableArray([]),
//	this.users.push(new TwitterUser("Pushkar", "@pushkarLadhe","3 hours ago","img/pushkar.png","Guys, Checkout iPhone 7... I loved it.I am going to buy it today!","img/iPhone7.jpg")),
 
     users: [
        new TwitterUser("Pranav", "@ppfirake","3 hours ago","img/pranav.jpg","Guys, Checkout iPhone 7... I loved it.I am going to buy it today!","img/iPhone7.jpg"," 29"," 31"),
        new TwitterUser("Harshal","@harshalDalvi","2 hours ago","img/harshal.jpg", "Check new Pixel from google. I guess it would be better choice","img/pixel.png"," 19"," 49"),
        new TwitterUser("Manasi","@manasi","3 min","img/manasi.jpg", "Umm.. I like my Samsung S7!!! Great Camera",""," 50",' 30')
        ],
        
        
		customtweetmsg:this.customtweetmsg,
		customcontentpic:this.customcontentpic,
        addTweet:function(){
		
         if( this.customtweetmsg != "" )
        {
        	
        	u= new TwitterUser("Pranav","@ppfirake","Just Now","img/pranav.jpg",this.customtweetmsg,this.customcontentpic);
		users.push(u);
           
        }
    }
};


        
//var Iamuser= new TwitterUser("Pranav","@pranavFirake","Just now","img/pranav.jpg", ""","")
//this.children.push(this.itemToAdd());
ko.applyBindings(viewModel);

