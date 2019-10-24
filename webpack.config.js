//https://start.goodtime.co.kr/2018/09/%ec%8a%a4%ed%94%84%eb%a7%81-%eb%b6%80%ed%8a%b8-%eb%a6%ac%ec%95%a1%ed%8a%b8-%ea%b0%9c%eb%b0%9c-%ec%85%8b%ec%97%85-2018/ 
//webpack config 셋업 참고링크
var path =require('path');

module.exports={
    context:path.resolve(__dirname,'src/main/webapp/feapps'),

    entry:'./src/index.js',
    devtool:'sourcemaps',
    cache:true,
    output:{
        filename:'./src/main/resources/static/js/react/[name].bundle.js',
        path:path.resolve(__dirname,'')
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
                test:/\.js?$/,
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