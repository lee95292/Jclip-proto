//https://start.goodtime.co.kr/2018/09/%ec%8a%a4%ed%94%84%eb%a7%81-%eb%b6%80%ed%8a%b8-%eb%a6%ac%ec%95%a1%ed%8a%b8-%ea%b0%9c%eb%b0%9c-%ec%85%8b%ec%97%85-2018/ 
//셋업 참고링크
var path =require('path');

module.export={
    context:path.resolve(__dirname,'src/main/feapps'),

    entry:{
        main: '',
    },
    devtool:'sourcemaps',
    cache:true,
    output:{
        path:__dirname,
        filename:'./src/main/webapp/js/react/[name].bundle.js'
    },
    mode:'none',
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
                test:/\.css$/,
                use:['style-loader','css-loader']
            }
        ]
    }
}