var page = require('webpage').create(),
    system = require('system'), 
    url = system.args[1], // url คือ argument ตัวที่ 1
    filename = system.args[2] || 'screenshot'; // filename คือ argument ตัวที่ 2 แต่ถ้าไม่ใส่มาให้ใช้ค่า screenshot แทน
 
page.open(url, function() {
    page.render(filename + '.png');
    phantom.exit();
});