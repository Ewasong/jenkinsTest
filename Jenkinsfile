pipeline {    
	agent any    
	tools {        
		maven 'mvn-3.5.4'    
	}
	options {	
		buildDiscarder(logRotator(numToKeepStr: '10'))
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
