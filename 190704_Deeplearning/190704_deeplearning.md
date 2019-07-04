# 2nd 함께하는 딥러닝 컨퍼런스(2nd DLCAT)
---

### AI시대의 예술작품 - AI Atelier를 이용하여 / 이수진
**Style Transfer**
- 사진 이미지와 그림 이미지의 상관관계
- 사진을 컨텐츠 이미지를 하고, transfer 하고 싶은 것은 그림으로
- 사진에 화풍을 적용한 그림을 만들어 내는 것
- Deepart.io, Prisma 

**A.I. Atelier**
- 사진에 그림 화풍을 적용할 수 있는 기술
- 인공지능 사진전을 열음

### 나도 너도 모르는 Graph Neural Network의 힘 / 김준태
**Graph structure**
- Adjacancy matrix(인접행렬)
- Node feature matrix 
    - 사람들간의 관계를 나타낼 수 있음

**Graph Neural Network**
- Node Classification
    - GNN은 node feature과 graph structure을 사용
- 구성
    - Aggregation : 주변 다른 노드에서 중심노드에 끌어 모으는 것
    - Combine : 끌어모았을 때, 주변 행렬과 본인을 업데이트하는 것
    - Readout : 하나의 백터로 나타내는 것(for classification)

**Graph SAGE**
- 자기 중심에서 얼마나 떨어진 곳에서 정보를 가져올지가 중점
    - 각 주변 깊이를 Layer로 표현

**Convolution**
- 로컬의 정보를 뽑아냄
- weight가 같음

**Code**
- Youtube '딥러닝 홀로서기'를 참고
- pytorch를 이용
- GCNBlock class에서 레이어를 몇개 쌓을 것인지 지정 할 수 있음
- 결국 행렬 연산으로 생각하면 다른 학습 모델을 적용하기 쉬워짐
    - 데이터를 구성하는 것이 핵심이 됨

**Graph Attention**
- 각 노드마다 연결 중요도가 다른 경우
- coefficient

**VQA**
- 이미지에서 학습 모델에 질문하고 그에 대한 대답을 체크하는 것
- 지역적인 관계를 따지는 것을 못하는 한계가 있음
    - 공간적인 질문을 해결할 수 없음
- ReGAT
    - Fast-R/CNN 으로 객체를 찾음
    - 비젼 정보를 feature로 생성
    - Bounding Box 도 feature로 생성
    - Relation
        - Explicit : 사전에 정의된 관계 그래프를 이용
        - Implicit : 연결을 모두 하고 연결이 약한 부분을 cut 함으로 남은 것들은 강한 연결관계를 가지고 있을 것임
    - Graph Construction
        - Implicit Graph : 모든 관계를 알 수 없으니 fully-connected 된 그래프를 생성하고 학습 과정에서 관련 없는 노드 edge를 제거
        - Explicit Graph
            - Spatial Relation : 공간적으로 Bounding Box가 겹치는지 확인을 통해 관계를 확인할 수 있음
            - Semantic Relation : 두 객체 사이의 관계가 양방향 그래프로 생성되어야함 (ex. 사람이 야구 방망이를 잡고 있음, 야구 방망이가 사람에게 잡혀 있음)

### 딥러닝으로 오디오 만나보기 / 남기현, 황준원
**A/D Converter**
- 연속적인 아날로그 신호를 표본화, 양자화, 부호화를 거쳐 이진 디지털 신호로 변화
- 나이키스트-섀넌 표본화

**Fourier Transform**
- 복합파를 정현파로 나누는 작업
- time 도메인 시그널을 frequency 도메인 시그널로 변경 할 수 있음
- 역함수를 통해서 다시 복원할 수 있음

**Cepstrum**
- 스펙트럼에서 log를 취하고 푸리에 역변환을 취한 결과
- 곱셈 연산을 덧셈으로 변경해줄 수 있음

**Librosa**
- python 에서 음성 데이터를 이용하는 라이브러리
- numpy와 오디오 양식을 오갈 수 있음
- sounddevice로 실시간 음성 처리
