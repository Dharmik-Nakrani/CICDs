def call(String sendMail ,String url) {
    def projectName = getProjectName()
    def subProjectName = getSubProjectName()
    def branchName = getBranchName()

    if(branchName == "Main")
    {
    mail mimeType: 'text/html' , body: html(subProjectName,branchName,url) , cc: 'devops.ebizzinfotech@gmail.com,coo.ebizzinfotech@gmail.com', from: "DevOps System", subject: "$projectName Project Build Successfully... 😀", to: sendMail
    }
    else{
    mail mimeType: 'text/html' , body: html(subProjectName,branchName,url) , cc: '', from: "DevOps System", subject: "$projectName Project Build Successfully... 😀", to: sendMail
    }

}

def getProjectName(){
    def values = env.JOB_NAME.split('/')
    return values[0]
}
def getSubProjectName(){
    def values = env.JOB_BASE_NAME.split('-')
    return values[1] + " " + values[2]
}
def getBranchName(){
    def values = env.JOB_BASE_NAME.split('-')
    return values[0]
}

def html(var_projectName,var_branchName,url){
    
    if(var_branchName == "Main"){
        var_environment = "Production"
    }else if(var_branchName == "Stage"){
        var_environment = "Staging"
    }else{
        var_environment = "Development"
    }    
    def var_buildNumber = env.BUILD_NUMBER

    return """
<!doctype html>
<html lang="en-US">

<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>Email Template</title>
    <meta name="description" content="Reset Password Email Template.">
    <style type="text/css">
        a:hover {
            text-decoration: underline !important;
        }
    </style>
</head>

<body marginheight="0" topmargin="0" marginwidth="0" style="margin: 0px; background-color: #f2f3f8;" leftmargin="0">
    <!--100% body table-->
    <table cellspacing="0" border="0" cellpadding="0" width="100%" bgcolor="#f2f3f8"
        style="@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;">
        <tr>
            <td>
                <table style="background-color: #f2f3f8; max-width:670px;  margin:0 auto;" width="100%" border="0"
                    align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td style="height:80px;">&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">
                            <a href="http://cicd.ebizzinfotech.com:9090" title="logo" target="_blank">
                                <div style="text-align:center;">
                                    <img src="https://mir-s3-cdn-cf.behance.net/user/276/93d735141051051.60374b7e1de32.gif"
                                        alt="" width="100" height="100" style="border-radius: 50px;">
                                </div>
                                <img height="80" width="500"
                                    src="https://www.ebizzinfotech.com/wp-content/uploads/2021/02/logo-black.png"
                                    alt="">
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td style="height:20px;">&nbsp;</td>
                    </tr>
                    <tr>
                        <td>

                            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"
                                style="max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);">
                                <tr>
                                    <td style="height: 250px;;">
                                        <img src="https://image.similarpng.com/very-thumbnail/2021/06/Green-check-mark-icon-on-transparent-background-PNG.png"
                                            width="100" height="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding:0 35px;">
                                        <h1
                                            style="color:#1e1e2d; font-weight:500; margin:0px 0px 15px 0px;font-size:32px;font-family:'Rubik',sans-serif;">
                                            $var_projectName Pipeline Successfully Completed.</h1>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table style="border-collapse: collapse; width: 80%; margin: auto;">
                                            <tr>
                                                <th colspan="2" style="text-align: center; border: 1px solid #dddddd;
                                                padding: 8px;">Project Details</th>
                                            </tr>
                                            <tr style="background-color: #dddddd;">
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">Project Name:</td>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">$var_projectName</td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">Branch Name:</td>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">$var_branchName</td>
                                            </tr>
                                            <tr style="background-color: #dddddd;">
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">Environment:</td>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">$var_environment</td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">Version:</td>
                                                <td style="border: 1px solid #bbbbbb;
                                                text-align: left;
                                                padding: 8px;">$var_buildNumber</td>
                                            </tr>
                                        </table>
                                        <p style="color:#455056; font-size:15px;margin:30px 0;">
                                            You can access your build from here <a href="$url" target="_blank">
                                                $url</a>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding:0 35px;">
                                        <span
                                            style="display:inline-block; vertical-align:middle; margin:10px 0 10px; border-bottom:1px solid #cecece; width:100px;"></span>
                                        <h5 style="font-family:'Rubik',sans-serif;">
                                            Note : If you have any concern regarding the pipeline please contact Dharmik
                                            N.(Skype Id -
                                            live:.cid.ddd1d378cb129cc8)</h5>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    <tr>
                        <td style="height:20px;">&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">
                            <p
                                style="font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;">
                                <strong>http://cicd.ebizzinfotech.com:9090</strong>
                            </p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>

</html>
    """
    
}
