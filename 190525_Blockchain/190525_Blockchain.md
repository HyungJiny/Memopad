#  블록체인
## 하석재 강사님 / 2HCUBE, CEO
### 2019.05.25.

---

### Naver 오픈소스 서버 기술
- https://naver.github.io/
    - mencached?
    - nbase-arc, ARCUS
- RDBMS
    - 느리다는 특징이 있음
    - HDD -> SSD -> Memory -> In-memory DBMS
        - In-memory 방식은 메모리가 최소 64GB 이상은 필요(cf. Exadata)
    - RDBMS Replication + NoSQL Cache server
        - 읽기는 RDBMS로, 쓰기는 NoSQL로
        - NoSQL(memcached/redis)
    - nbase-arc
        - MariaDB에 샤딩을 하는 오픈소스
- 그 회사에 취직하고 싶으면 해당 회사의 사용 소프트웨어를 이해해야함

### 합의(Consensus) 알고리즘
- 블록 생성 권한과 합의는 다름
    - 블록 길이가 서로 다른데 어떤게 맞는거야? 긴게 맞는 겁니다. -> 합의

### Hyperledger Fabric
#### Peer and Channels
- Anchor peer : 다른 peer 들어게 전달할 사항을 본인이 받아 전달함
- Leading peer : Anchor에게 전달받은 내용을 배포하는 p2p 모양의 네트워크에서 header 역할을 하는 peer
    - Gossip의 head를 leader라고 부름
    - Anchor와 Leader가 같을 수 있음
- Endorsing peer
- Committing peer

#### Gossip protocol
- Leader peer : Orderer에게 전달받아 배포를 책임지는 노드
- 피어들이 Linked list 형태로 연결되어있는 것
- 내용을 전달하는 방식

#### Private Data Collection
- orderer를 거치지 않고, 피어들끼리 데이터를 공유, 접근할 수 있는 방법

#### Consensus Algorithm
- 사실상 합의 알고리즘이 존재하지 않음
- 단순히 2초마다 orderer 패키징을 진행함
    - 순서대로 쌓기만 함
- CFT
    - Kafka (=Queueing, Buffering)
    - 서버가 죽지 않도록 관리해주는 것
    - Zookeeper - High Availabity(고가용성)
        1. Master - Slave(수동) : 다음 후보가 미리 정해져있음
        2. Active - Standby : election, 다음 후보를 새로 뽑음
        3. Active - Active
- BFT
    - PBFT 사용(0.6)
    - SBFT 2.0

### 보안
- 공개키와 비밀키
    - 공개키(RSA)가 보안 수준은 더 높음
    - 공개키 방식이 느리기 때문에 비밀키도 사용
    - 속도에 무관하면 공개키를 이용하는 것이 무조건 좋음
- 최근 공개키 방식의 대표인 RSA를 개선하고 있음
    - el gamal
    - eliptic curve(타원 곡선)
- 인증서
    - 거래 당사자가 신뢰할 수 있다는 증명서
    - 웹의 경우 베리사인(Verisign)사가 발급
        - Verisign : Visa와 Master가 만든것
