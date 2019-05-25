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
- 