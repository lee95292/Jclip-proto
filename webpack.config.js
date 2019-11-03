//https://start.goodtime.co.kr/2018/09/%ec%8a%a4%ed%94%84%eb%a7%81-%eb%b6%80%ed%8a%b8-%eb%a6%ac%ec%95%a1%ed%8a%b8-%ea%b0%9c%eb%b0%9c-%ec%85%8b%ec%97%85-2018/ 
//webpack config 셋업 참고링크
var path =require('path');
const getLogger=require('webpack-log');
const log=getLogger({name:'webpack-batman'});

module.exports={
    // context:path.resolve(__dirname,'src/main/'),
    
    entry:path.resolve(__dirname,'src/main/webapp/feapps/src/index.js'),
    devtool:'sourcemaps',
    cache:true,
    output:{
        // path:path.resolve(__dirname,'src/main/resources/static/js/'),
        // filename:'[name].bundle.js',
        path:__dirname,
        filename:'./src/main/resources/static/js/[name].bundle.js',
        path:path.resolve(__dirname,'/src/main/resources/static/js'),
        publicPath:'/static/js/'
    },
    mode:'none',
    devServer:{
        inline:true,
        hot:true,
        contentBase:[path.resolve(__dirname,'src/main/webapp/WEB-INF'),path.resolve(__dirname,'src/main/resources/')],
        watchContentBase:true,
        index:'./webapp/WEB-INF/index.html',
        host:'localhost',
        port:9000
    },
    module:{
        rules:[
            {
                test:/\.js?$/,
                exclude:/(node_modules)/,
                use:{
                    loader:'babel-loader',
                    options:{
                        presets:['@babel/preset-env','@babel/preset-react']
                    }
                }
            },
            {
                test:/\.jsx?$/,
                exclude:/(node_modules)/,
                use:{
                    loader:'babel-loader'
                }
            },
            {
                test:/\.css$/,
                use:['style-loader','css-loader']
            }
        ]
    }
}

log.info('outputPath:'+module.exports.output.path);
log.info('devserver contentbase:'+module.exports.devServer.contentBase);
log.info('devserver index:'+module.exports.devServer.index);
log.info(module.exports.entry.path);

// log.info('Jingle Bells, Batman Smells');
// log.warn('Robin laid an egg');
// log.error('The Batmobile lost a wheel');
// log.debug('And the Joker got away');