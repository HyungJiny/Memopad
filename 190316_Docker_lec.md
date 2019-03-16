# Docker 특강
## 하석재 강사님 / 2HCUBE, CEO
### 2019.03.16

---

### Docker
도커 - (격리: isolation)

**특징**
- 가볍다
- 똑똑하다

**기술적 특징**
- 도커는 윈도우를 지원하지 않음
    - 운영체제가 2개 설치되는 것이 아님(host의 자원을 이용)
    - 원래는 Ubuntu만 지원, 요즘은 Linux도 지원
    - Windows container라는 개념을 만듬
- 3개의 기능
    - LXC(Linux Containers)
    - Aufs(Advanced multi layered unification filesystem)
    - 이미지 버전컨트롤 시스템
- Go 언어로 작성됨
- 도커는 root 권한이 있어야 실행 가능함(좋은걸까?)
    - 보안 취약점
- 도커는 hypervisor 기능이 있음(100%는 아님, 필요 기능만)
    - 모든 기능을 사용하기 위해서는 LXD가 필요
    - Ubuntu에서 실행해야 Docker를 제대로 사용 가능
- Ubuntu 의존성을 해결하기 위해 LXC 외에 Libcontainer 제작
    - 실행 드라이버(exec driver)라고 부름
    - 현재는 RunC로 통합됨(컨테이너가 Docker만 있는 것은 아님)
- 도커 저장소(로컬 레포지토리)
    - load / save 명령어 -> 이미지를 파일로 생성 가능

```bash
$ docker save -o [file_name].tar [image_name]
$ docker load -i [file_name].tar
```

**LXC**
- Linux Containers
- Ubuntu에만 있는 기능
- 시스템 레벨 가상화
    - cgroups
        - CPU, 메모리, 디스크, 네트워크 설정
    - Namesapces
        - 프로세스트리, 사용자계정, 파일시스템, IPC, ...
        - 호스트와 별개의 공간설정
    - hypervisor를 만들려고 뺐던 기능
        - OpenStack hypervisor KVM(Kernel VM) -> LXC -> LXD
        - .dll -> .so(application module) / .ko(kernel module)
- chroot(change root) 명령어에서 발전
    - chroot jail
    - chrrot 상의 폴더에서 외부 디렉토리 접근 안 됨

**LXD**
- LXC에 보안 개념을 추가
- root가 아니여도 컨테이너 생성 가능
- Ubuntu만 되는 기능
- Container "Hypervisor"

### Linux mint에 Docker 설치하기

1. 우선 패키지 업데이트를 진행
```bash
$ sudo apt-get update
```

2. 필요 패키지를 설치
```bash
$ sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common
```

3. GPG 키를 받아오기
```bash
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

4. Docker repository 추가하기
```bash
$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"
```

5. 업데이트 후 docker ce 버전 설치
```bash
$ sudo apt-get update
$ sudo apt-get install docker-ce docker-ce-cli docker-compose containerd.io
```

### Docker 간단 명령어
- Ubuntu 이미지 다운 및 실행
```bash
$ docker run -it --name=[container_name] [image_name]
```
이미지 이름 뒤에 콜론(:)을 통한 버전 설정이 없으면 자동으로 latest로 적용됨.
```
-p(publish) : 포트 노출
# NAT(포트포워딩)
# telnet 23, ftp 21, ssh/scp 22, smtp 25, http 80/443(SSL), tomcat 8080, oracle 1521, mysql 3306

-d(detach)/--detach : 서버형 실행

-e(env)/--env : 환경변수 설정
# 환경변수 : 프로세스마다 있는 영역

-i(interactive) : 표준입력 열어두기

-t(tty) : 터미널 인터페이스

-v(volume) : 호스트 디렉토리 연결
# Data Directory(DBMS에서 실제 데이터가 저장되는 위치)
# 컨테이너의 폴더 - 물리디스크의 폴더 마운트
# cf. 볼륨 컨테이너 : 아무 동작을 하지 않고 볼륨(디스크)만 가지고 있는 컨테이너 
# 서로 다른 컨테이너가 볼륨 컨테이너를 공유할 수 있게 되는 장점이 있음

-w(workdir) : 작업디렉토리 설정

-l(link)/--link : 컨테이너 연결
# 컨테이너끼리 연결되지 못하게 격리되어 있는데 이를 연결해줄 필요 있을 때 사용(방법이 까다로움)
```

- 동작중인 컨테이너 확인
```bash
$ docker ps -a
```

- 컨테이너 실행
```bash
$ docker start [container_name]
```

- bash 실행시키기
```bash
$ docker exec -it [container_name] bash
```

- 동작중인 이미지 확인
```bash
$ docker images
```

- 컨테이너 지우기
```bash
$ sudo docker rm [container_name] # 실행 중지 후 삭제
$ sudo docker rm -f [container_name] # 실행 중지 없이 바로 삭제
```

- 컨테이너 IP 주소 알아내기
```bash
$ docker inspect [container-name] | grep "IPAddress"
```

### OS 관련 이야기
요즘 윈도우는 Bash Shell을 탑재하고 나옴.
>Windows WSL = Windows Kernel + Linux(Bash) Shell

그렇다고 리눅스가 필요 없는가?
커널은 윈도우를 이용한다는게 문제
>Kernel(file system, nerwork ...)

윈도우와 리눅스의 파일시스템에 차이가 있어서 제대로 동작하는지 확인해야함
>NTFS, FAT(Windows) <-> Ext4fs(Linux)

우분투에서 운영체제 확인하기
```bash
$ cat /etc/issue
Ubuntu 18.04.2 LTS \n \l
```

* Linux
    * Redhat (yum)
        * Fedora / Redhat Enterprise Linux(RHEL) / CentOS
    * Debian (apt)
        * Ubuntu Server / Desktop

CISC와 RISC

itanium(Intel) - 망함 / AMD64(AMD) (Intel: x86-64)
x64

IBM PC PC-DOS -> 호환 MS-DOS BIOS
-> 386 PS/2 OS/2 -> Windows NT (요즘의 Windows 서버)
-> 컴팩 386 AT (286 컴퓨터에 386이 장착되어 나옴)

### 환경변수 이야기(-e 옵션)
- 환경변수 : 프로세스마다 있는 영역
- set PATH(Windows) / export PATH(Linux)
- 모든 운영체제에서 동작할 수 있도록 설정하기 위함(구식이지만 공통점)
- 현경변수 설정법 : export SAMPLE=test
- 환경변수 확인법 : echo $SAMPLE / env | grep SAMPLE
- 도커에서는 이 방법이 안먹혀서 옵션으로 추가해주어야함 혹은 ENV(Dockerfile)을 이용
- 자식 프로세스가 실행되면서 부모 프로세스를 복사함
    - 부모랑 같은 것은 아님
    - 프로세스마다 환경변수는 설정되는 것이므로 자식 프로세스에서 새로운 환경변수를 설정 후, 부모 프로세스에서 같은 환경변수를 확인해보면 없음

### MySQL 서버로 클라이언트 컨테이너 연결하기(-l 옵션)
서버와 클라이언트 만들기
```bash
# mysql 서버 생성
$ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cnu --name=mysql1 mysql
# 연결할 클라이언트 서버 생성
$ docker run -it -l mysql1:mysql1 --name=mysql_client ubuntu
```

클라이언트에 필요 패키지 설치
```
# apt update
# apt install vim
# apt install mysql-client
# mysql -h mysql1 -uroot -p
```

서버 mysql 접속하기(mysql 서버에서 mysql을 킨 상태에서)
```
# mysql -h mysql1 -uroot -p
```
접속이 안된다면 `docker inspect` 명령어를 통해 서버 ip를 알아내어 직접 접속

단, 호스트 시스템 한 대를 설정 가능
여러대를 관리하기 위해서는 스웜, 쿠버네티스 등을 이용해야함

### port 이야기
NAT : IP 공유기(실제 IP 안에서 내부 IP를 생성해주는 것)

ex)
* 12.34.56.78(실제 IP)
    * 172.17.0.2 
    * 172.17.0.3 
    * 172.17.0.4 

**내부 네트워크에서 서버(서비스, 방화벽)를 운영하면?**

포트포워딩(Port Forwarding)
12.34.56.78:80 -> 172.17.0.3:80
12.34.56.78:81 -> 172.17.0.4:80
내부에서 같은 포트번호를 이용하면 외부에서 포트포워딩을 통해 둘을 나누어주면 됨

Docker에서 포트포워딩을 설정해놓은 ip가 있음 : `192.168.99.100`
Windows 상황에서는 Virtualbox 기반의 Docker toolbox를 이용해 docker 이용
12.34.56.78 -> 10.0.2.15 -> 172.17.0.2 | 3단계를 거쳐야하느 문제가 생김

### Dockerfile 기초
자동화!!

**도커에서 이미지 생성하는 방법**
- commit 사용
    - 직접 컨테이너에 작업한 후 이미지 생성
- Build
    - Dockerfile을 만들고 이를 기반으로 이미지 생성

빈 폴더에 dockerfile이 있어야함. build를 할 때 모든 파일을 다 읽어오기 때문에
```bash
$ mkdir dockerfiletest
$ cd dockerfiletest
$ vi Dockerfile

FROM ubuntu:latest
MAINTAINER Hyungjin Lee <hyungjin.lee1004@gmail.com>

RUN apt update
RUN apt install nano
ENV TERM=xterm

$ docker build --tag=ubuntu_nano .
```

**단점**
각 라인이 제대로 동작하는지 확인하는 방법?
commit 방법을 통해 제대로 되는지를 확인해봐야함
수작업과 자동화를 동시에 해봐야하는 문제가 발생함

네트워크가 느리면 오래걸림

### Java 실습
Java의 핵심은 `JVM` 어디서든 돌아갈 수 있도록 하는 가상머신
윈도우에서 개발 -> 리눅스 서비스(99%) > DepOps와 연관

Java가 설치된 이미지 만들기
```
FROM ubuntu:latest
MAINTAINER Hyungjin Lee <hyungjin.lee1004@gmail.com>

RUN apt-get update
RUN apt-get install vim
RUN apt-get install -y openjdk-8-jdk
RUN apt-get clean

ENV TERM=xterm

ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CLASSPASS=$JAVA_HOME/lib/*:.
ENV PATH=$PATH:$JAVA_HOME/bin
```

**Oracle Java vs. Open Java**
Ubuntu는 Open Java랑 친함
Redhat은 Oracle이랑 친함

빌드된 이미지로 Java 테스트 해보기
```
# vi HelloWorld.java

class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello!");
    }
}

# javac HelloWorld.java
# java HelloWorld
Hello!
```


### Docker-compose
도커 이미지의 설정을 저장하는 방법(yaml의 형식) 
암호화 되어있는 것을 사용자가 쉽게 접근할 수 있도록 하자!
여러대의 컨테이너를 동시에 올리고 내리고 하자!

```bash
$ vi docker-compose.yaml

version: '2'
services:
 db:
  image: mysql:5.7
  environment:
   MYSQL_ROOT_PASSWORD: cnu

$ docker-compose -f docker-compose.yaml up # run
$ docker-compose -f docker-compose.yaml down # remove
```

원래 별도의 프로젝트였으나 도커로 통합됨

### 오케스트레이션(orchestration)
도커를 기반으로 해서 여러 대의 물리적인 시스템을 연결해서 관리하는 기술
- 도커 스웜(Swarm)과 쿠버네티스(Kubernetes)가 있음
- PaaS의 기능과 상당부분 중복
    - 일종의 PaaS 대체제 기술

**기능**
- Scheduling(핵심)
    - 각 노드들에 요구사항이 맞는 컨테이너를 맞춰 끼움
    - 최적의 노드를 찾아 배치
- High Availability(고가용성)
    -  클러스터 내의 서버가 다운됐을 때 대응
    - 서비스는 하나이지만 실제로는 여러개를 띄워 하나가 죽어도 서비스를 이용할 수 있도록 하는 것
- Scalability
    - 성능을 지속적으로 향상시키는 기능
    - 성능 요구가 늘어나면 컨테이너를 자동으로 늘림

**Swarm vs. Kubernetes**
- 쿠버네티스
    - 강력한 기능 / 복잡한 설정
    - 500대의 서버에 50,000 컨테이너를 서비스 가능
- 스웜
    - 비교적 간단한 설정
    - 50대 미만의 경우 스웜을 사용하는 것이 유리

**컨테이너 vs. 가상머신**
- VMware의 CloudFoundry의 입장
    - VM/컨테이너는 OS의 프로세스/쓰레드의 관계
- Kubernetes / Openshift의 입장
    - 컨테이너와 가상머신은 다른 것
    - 가상머신보다 컨테이너가 가벼우니 전환하자

### 정리
- 하이브리드 클라우드 기술의 대두
    - 여러 개의 클라우드를 같이 사용
    - 여러 클라우드를 사용해서 큰 서비스 구축 가능
        - On-Premise(자체 구축) + AWS + Azure + ...
        - 각 회사에서 잘하는 내용을 가져와서 사용
- 컨테이너 기술의 대두
    - 기존의 가상화기술보다 가볍고 똑똑하며, 활성화 됨
- 오케스트레이션 기술의 대두
    - 기존의 대형서비스 배포(deploy) 기술의 대체제
        -VMWare vCenter, vSphere

---
## 참고문헌
- 강의자료 : <https://docs.google.com/presentation/d/1ooJZ1U5i1F6xAdltq3OmDCiYFmJY3neov3kttwciPew/present?slide=id.p>
- 가장 빨리 만나는 도커(Docker) : <http://pyrasis.com/private/2014/11/30/publish-docker-for-the-really-impatient-book>