pipeline {    
	agent any    
	tools {        
		maven 'mvn'    
	}    
	stages {        
		stage("build") {            、
			steps {                
				sh "mvn clean package spring-boot:repackage"                
				sh "printenv" // 将环境变量打印            
			}       
		}   
	}
}
