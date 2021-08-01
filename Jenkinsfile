pipeline {    
	agent any    
	tools {        
		maven 'mvn-3.5.4'    
	}
	options {	
		buildDiscarder(logRotator(numToKeepStr: '10'))
		// 禁止并行构建
		disableConcurrentBuilds()
	}
	stages {        
		stage('build') {          
			steps {                
				sh "mvn clean package spring-boot:repackage"                
				sh "printenv" // 将环境变量打印            
			}       
		}   
	}
}
