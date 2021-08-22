pipeline {    
	agent any    
	tools {        
		maven 'mvn-3.5.4'    
	}
	options {	
		buildDiscarder(logRotator(numToKeepStr: '10'))
		// 禁止并行构建
		disableConcurrentBuilds()
		// 失败重试 包括第一次失败
		retry(4)
		// 超出设置的时间，将终止pipeline 报错
		// timeout(timeout: 10, unit: 'HOURS')
	}
	stages {        
		stage('build') {          
			steps {                
				sh "mvn clean package spring-boot:repackage"                
				sh "printenv" // 将环境变量打印            
			}       
		}
		stage('Example') {
		    steps {
		        script {
		            def browsers = ['chrome', 'firefox']
		            // 单引号没办法替换变量
		            for (int i = 0; i < browsers.size(); i++) {
		                echo "Test the ${browsers[i]} browser"
		            }
		        }
		    }
		}

	}
	post {
	    always {
	        junit testResults: '**/target/surefire-reports/*.xml'
	    }
	}
}
