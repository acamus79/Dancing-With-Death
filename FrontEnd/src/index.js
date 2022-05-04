
const {app, BrowserWindow, Menu} = require('electron')
const url = require('url');
const path = require('path');

let mainWindow
let aboutWindow

app.on('ready', () =>{
    mainWindow =   new BrowserWindow({
        title: 'Quien Cumple años hoy?'
    });
    mainWindow.loadURL(url.format({
        pathname: path.join(__dirname, 'views/index.html'),
        protocol: 'file',
        slashes: true
    }))

    const mainMenu = Menu.buildFromTemplate(templateMenu) ;
    Menu.setApplicationMenu(mainMenu);

    mainWindow.on('closed', () => {//al cerrar la ventana principal cierro toda la aplicacion
        app.quit();
    });
});

function createAboutWindow(){
    aboutWindow = new BrowserWindow({
        width:400,
        height:330,
        title: 'Acerca de...'
    });
    aboutWindow.setMenu(null);//de esta manera oculto el menu en una ventana
    aboutWindow.loadURL(url.format({
        pathname: path.join(__dirname, 'views/about.html'),
        protocol: 'file',
        slashes: true
    }));
    aboutWindow.on('closed', () =>{ //al cerrar la ventana Limpio la memoria
        aboutWindow = null;
    });
}

const templateMenu = [
    {
        label: 'MENÚ',
        submenu: [
            {
                label: 'HOY',
                accelerator: process.platform == 'darwin' ? 'command+H' :'Ctrl+H',
                click(){
                    mainWindow.loadURL(url.format({
                        pathname: path.join(__dirname, 'views/index.html'),
                        protocol: 'file',
                        slashes: true
                    }))
                }
            },
            {
                label: 'MAÑANA',
                accelerator: process.platform == 'darwin' ? 'command+M' : 'Ctrl+M',
                click(){
                    mainWindow.loadURL(url.format({
                        pathname: path.join(__dirname, 'views/indexm.html'),
                        protocol: 'file',
                        slashes: true
                    }))
                }
            },
            {
                label: 'INFORMACIÓN',
                accelerator: process.platform == 'darwin' ? 'command+I' : 'Ctrl+I',
                click(){
                    createAboutWindow()
                }
            },
            {
                label: 'SALIR',
//darwin es como decir MacOs, entonces si la plataforma que esta corriendo electron es MacOs el atajo de teclado será Command + Q
                accelerator: process.platform == 'darwin' ? 'command+Q' : 'Ctrl+Q',
                click(){
                    app.quit();
                }
            }
        ]
    }
];

//esto es por si se utiliza en un entorno de MacOs, cambie la etiqueta del Menú
if(process.platform === 'darwin'){
    templateMenu.unshift({
        label: app.getName()
    });
}
