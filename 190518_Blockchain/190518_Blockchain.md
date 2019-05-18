#  블록체인
## 하석재 강사님 / 2HCUBE, CEO
### 2019.05.18.

---
- **Ledger** : 은행/증권회사에서 예금, 대출, 송금 및 거래를 기록한 문서

### Ledger 관리방식의 비교
- 현재는 비싼 복제(expensive replication) 사용
    - RDBMS 복제
    - 고성능 네트워크
        - SLA: 서비스에 문제가 생겼을 때, 보장하기 위한 범위를 지정해놓는 것 (일반 인터넷 Max : 100Mbps, Min : 0Mbps)
    - 막대한 관리비용
- 블록체인은 싼 복제(cheep replication) 사용
    - 자체 복제기능 사용
    - 인터넷만 연동되어 있으면 가능
    - 저렴한 관리비용

### Hash
- 비교를 한 번만 해도 찾을 수 있음
- 보안 Hash - 원본과 Hash 값을 같이 저장하고, 저장된 값이랑 Hash가 같은지 확인

### 블록체인의 3중 조작방지 시스템
- 하나의 블럭을 안정하게 암호화
    - 비트코인은 SHA-2(SHA-256), 하이퍼렛저는 SHA-2/3 사용
- 블록체인은 안정성, 보안성을 중요시하여 만들었기 때문에 느린것이 정상
    - 한 번 기록되면 수정하기 힘듬

### 합의(Consensus) 알고리즘
- All
    - 모두가 동의
- Any
- Quorum(1/2, 2/3)
- 정족수 : 절반이상 데이터가 업데이트되면 만족
- BFT
    - 비잔틴 결함내성
        - 비잔틴 장군의 딜레마(알고리즘 문제)
    - 의도적으로 거짓말을 하는 노드를 허용
    - 1/3 이하면 결론은 영향을 받지 않음
- 작업 증명
    - PoW(Proof of Work)
    - 어려운 문제(해시 nounce값 계산)를 빨리 푼 노드에게 블럭 생성 권한을 주는 방식
    - 물리적으로 실제로 빠르게 처리하는 것을 구분하기 힘듬
        - 제한 시간(1시간) 안에 가장 많은 블록을 계산한 사람에게 보상
    - 블럭 하나 생성하기 위해 필요한 해시 파워는 5,000,000TH/s
- 위임지분증명(Delegated PoS)
    - 합의를 빠르게 하기 위해 지분을 위임하는 방식
    - EOS의 기본 합의 방식

### DBMS의 복제 방식
- Statement-based 복제
    - 동일한 SQL을 복제
    - 결과가 동일하지 않을 수 있음(non-determinsitic)
        - 타임스탬프/난수를 사용하는 쿼리
- Row-based 복제
    - SQL의 실행결과 업데이트된 행을 복제
        - 결과를 return 해줌
    - 트래픽 발생 여지
        - update를 했는데 row가 많으면 모두를 다시 보내주어야하므로 문제 발생
    - 결과가 동일(deterministic)
- Hybrid 복제

### 알트코인
- 분권화된 자율 조직 및 애플리케이션(DAO)
    - 코인 판매해서 펀드를 만들고 벤처투자
    - 이더리움 / 이더리움 클래식이 하드포크된 원인

### 코인(Coin) vs. 토큰(Token)
- 독립된 메인넷을 가지고 있는지
    - Ethereum vs. EOS
    - ERC20 토큰

### 기존 블록체인의 문제점
- 성능이 낮다
- 꼭 가상화폐를 필요로 한다
- 거버넌스가 약하거나 없다
- 프라이버시가 없다

### 파라이빗 블록체인
- 권한이 있는 사람만 서버 접근 가능해야함
- 허가형 블록체인
    - 허가된 노드만 들어와서 허용된 동작만 허용
    - IBM Hyperledger
    - EEA
    - R3 Corda

### Hyperledger Fabric
- 사설(private)이면서 허가형(permissioned)
- MSP(Membership Service Provider)를 통한 등록
- 보든 결과가 같아야함(Validation)
    - 블럭이 생성되고 다른 피어와 결과가 다른 경우 변경될 수 있음으로 판단하고 제거
    - 같은 채널의 가입된 블럭은 모두 같음
- CFT
- 합의 과정은 없음
- 

#### Transaction
- commit / rollback
- WAS(Web Application SErver)
    - JEUS, Weblogic
    - WAS + DBMS

#### Open Source 버전 개발 과정
- Alpha -> Beta -> RC(Release Candidate) -> RTM(Ready to Manufacturing) -> Service Pack(Redstone)
- Edge -> Stable -> LTS(Long Term Support)/GA(Generally Available)

