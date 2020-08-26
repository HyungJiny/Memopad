# Automatic Bitcoin Address Clustering
## Dmitry Ermilov, Maxim Panov, Yury Yanovich

### Abstract
Bitcoin은 암호화를 지원하는 전 세계적으로 동일한 이름의 분산된 디지털 자산 인프라입니다.
모든 Bitcoin의 소유와 이체 이력은 blockchain이라 불리는 공통 ledger로 활용될 수 있다.
그러나 현실에서는 주소의 주인을 알 수 없습니다.
이것이 Bitcoin이 pseudo-anonymous라고 불리는 이유입니다.
그러나 일부 주소는 그들의 행동 패넡과 off-chain으로 부터의 공개적인 정보를 통해 그룹지어질 수 있습니다.

Blockchain 기반의 공통 행동 패턴 분석(common spending과 one-time change heuristics)은 널리 사용된다 bitcoin 클러스터링에 주소를 연결시키는 것에 대한 투표로, 반면에 off-chain 정보는 결과를 검증하는데 이용된다.
이 논문에서, 우리 목표는 off-chain 정보를 통해 주소를 구분하고 같은 blockchain 정보를 통해 클러스터링 모델을 구축하고 같다고 고려하는 것이다.
blockchain과 off-chain 정보는 진짜가 아닐 수 있다. 그리고 우리는 잘못된 정보를 걸러내는 것을 목표로 한다.

우리의 연구 결과는 실현 가능한 Bitcoin 주소 클러스터링을 달성하였다.
이는 유용할 수 있다 안전하지 않은 Bitcoin 사용 패턴을 피하고, 수사관들이 비익명적인 분석을 내놓을 수 있도록 하는 것에

### Introduction
Bitcoin은 널리 알려진 전세계적 가상화폐이다.
이는 분산된 네트워크를 지원하는 것의 시초이다.
Bitcoin 교환 매체는 동일한 이름의 지불 단위이다.
가상화폐는 전송된다 트랜잭션을 통해 공통된 암호화 기법(디지털 인증과 해시 함수 같은)을 근본으로 인증 수단을 증명하기 위해.
모든 트랜잭션은 포함한다 공통적으로 가능한 분산된 ledger(blockchain)를 Bitcoin 네트워크 안에서 인증된 노드에 의해서.
현재, Bitcoin은 가장 널리 이용되고 가장 안전한 blockchain 서비스이다. 디지털 금융 인프라와 보안 blockchain 메세징 시스템에서.

Bitcoin에서 중요한 요소 중 하나는 익명성이다.
Bitcoin 네트워크의 참여자들은 bitcoin의 소유권을 공개할 의무가 없다.
그러나 bitcoin 소유자의 데이터는 일반적으로 이용할 수 없다.
하지만 주어진 트랜잭션 히스토리와 Bitcoin 사용자가 스스로 공개한 데이터는 특정 bitcoin의 정보를 복구할 수 있다.
우리 논문의 목표는 Bitcoin 클러스터링 알고리즘을 증명하는 것이다 모든 주소에 대해 각 클러스터가 같은 사용자를 찾는 것에.

익명성과 비 익명성의 Bitcoin 시스템 연구는 최근 몇 년 동안 활발하게 발전하고 있으며 blockchain(트랜잭션 분석)과 off-chain 정보(인터넷에 공개된 공통 분석 정보)가 사용된다.
익명성과 비익명성에 대한 기술 개요는 관련연구에서 설명된다.
익명성을 가능하게 하는 것은 코인을 공유하고 믹서를 보내는 것, 