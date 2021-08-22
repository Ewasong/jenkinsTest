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
				jacoco(
				    // 代码覆盖率统计文件位置
				    execPattern: 'target/**/*.exec',
				    // class文件位置
				    classPattern: 'target/classes',
				    // 源文件位置
				    sourecePattern: 'src/main/java',
				    // 排除分析的位置
				    exclusionPattern: 'src/test*',
				    // 是否禁用每行覆盖率的源文件显示
				    skipCopyOfSrcFiles: false,
				    // 如果true，对各维度的覆盖率进行比较，任何一个维度的当前覆盖率小于最小阈值，就构建失败，
				    // 如果在最小和最大阈值之间，则构建状态为不稳定，如果大于最大阈值，就构建成功
				    changeBuildStatus: true,
				    // 字节码指令覆盖率
				    minimumInstructionCoverage: '30', maximumInstructionCoverage: '70',
				    // 行覆盖率
				    minimumLineCoverage: '30', maximumLineCoverage: '70',
                    // 圈复杂度覆盖率
                    minimumComplexityCoverage: '30', maximumComplexityCoverage: '70',
                    // 方法覆盖率
                    minimumMethodCoverage: '30', maximumMethodCoverage: '70',
                    // 类覆盖率
                    minimumClassCoverage: '30', maximumClassCoverage: '70',
                    // 分支覆盖率
                    minimumBranchCoverage: '30', maximumBranchCoverage: '70',
                    // true-> 只有所有维度的覆盖率变化量绝对值小于相应的变化量覆盖率时，构建才成功
                    buildOverBuild: true,
                    // 以下是各个维度的变化量阈值
                    deltaInstructionCoverage: '30',
                    deltaLineCoverage: '30',
                    deltaComplexityCoverage: '30',
                    deltaMethodCoverage: '30',
                    deltaClassCoverage: '30',
                    deltaBranchCoverage: '30',
				)
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
