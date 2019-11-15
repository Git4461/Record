system = require('system')   
address = system.args[1];//获得命令行第二个参数 接下来会用到   
//console.log('Loading a web page');   
var page = require('webpage').create();   
var url = address;
page.customHeaders = {
    "Accept":" text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    // "Accept-Encoding":" gzip, deflate, br",
    "Accept-Language":" zh-CN,zh;q=0.9",
    "Cache-Control":" max-age=0",
    "Connection":" keep-alive",
    "Cookie":" BAIDUID=DAB2584B350C49C683A8F4B01ADBF3BF:FG=1; PSTM=1569028139; BIDUPSID=B2984D823C711B25AFEE6B8A1B621755; BD_UPN=12314753; MCITY=-75%3A; H_PS_PSSID=1456_21123_18560_29567_29699_29220_26350; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDSFRCVID=asIOJeC6277p1vvw1CwLU1-W9eS1ZPrTH6aIEYzunIWfD1_O28sZEG0P_U8g0KubPl0FogKKXgOTHw0F_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF=tJKeoC_5JKD3hDD9q4TDM4t-haLX5-CsK67A2hcH0KLKMI3xDJj-5T_d5PvPJCrUfCTgoxcx-fb1MRjVQqr05tCP3UjRJlR9tJbehq5TtUJrSDnTDMRh-l8jD-jyKMniyIv9-pn5tpQrh459XP68bTkA5bjZKxtq3mkjbPbDfn02eCKu-n5jHjQ0DHAO3H; sugstore=1; delPer=0; BD_CK_SAM=1; PSINO=6; BD_HOME=0; plus_lsv=f197ee21ffd230fd; plus_cv=1::m:49a3f4a6; Hm_lvt_12423ecbc0e2ca965d84259063d35238=1573804061; SE_LAUNCH=5%3A26230067_0%3A26230067; H_PS_645EC=17c6oslhPDHrrjbwW%2FV67hUS51%2BbO3ZlZUyQOuwD1ovyUWhRvGTQfyNIt4c; H_WISE_SIDS=138175_137150_137735_134724_136626_135846_138105_137373_120138_136600_137381_137788_136382_137979_132911_136456_137690_131246_137745_132378_136681_118884_118863_118844_118833_118786_107316_136431_122035_136091_133352_137900_136862_138324_138114_129647_136195_137105_137573_133847_132552_138343_137468_134046_131423_137466_136537_110085_137863_127969_136533_137829_138150_127416_136635_137767_137208_137450; rsv_i=e4a3msd1%2FxniOa3ke8CGA5B063uXR20GKvcVZAR%2BoxSU2Zv9UflU%2FuzqyBL0mB4pZ5vdI7ZUsiBj9%2BoVMg0a8jBryyhtsSY; BDSVRTM=256; Hm_lpvt_12423ecbc0e2ca965d84259063d35238=1573804476",
    "Host":" www.baidu.com",
    "Referer":" https://www.baidu.com/s?ie=UTF-8&wd=123",
    "Sec-Fetch-Mode":" navigate",
    "Sec-Fetch-Site":" same-origin",
    "Sec-Fetch-User":" ?1",
    "Upgrade-Insecure-Requests":" 1",
    "User-Agent":" Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Mobile Safari/537.36"
};
page.open(url, function (status) {
    //Page is loaded!   
    if (status !== 'success') {   
        console.log('Unable to post!');   
    } else {   
        //console.log(page.content);   
        //var title = page.evaluate(function() {   
        //  return document.title;//示范下如何使用页面的jsapi去操作页面的  www.oicqzone.com 
        //  });   
        //console.log(title);   
           
        console.log(page.content);   
    }      
    phantom.exit();   
});