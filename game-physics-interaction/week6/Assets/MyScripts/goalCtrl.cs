using UnityEngine;

public class goalCtrl : MonoBehaviour
{
    private bool is_collided = false;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        transform.position = new Vector3(Random.Range(7.0f, 10.0f), Random.Range(-3.0f, 2.0f), 0);
    }

    // Update is called once per frame
    void Update()
    {

    }

    private void OnCollisionEnter(Collision other)
    {
        this.is_collided = true;
        other.transform.GetComponent<Rigidbody>().constraints = RigidbodyConstraints.FreezeAll;
    }

    private void OnGUI()
    {
        if (is_collided)
        {
            GUI.Label(new Rect(Screen.width / 2 - 120, 80, 240, 20), "다시 시작하려면 아무 키나 누르세요");
            if (Input.anyKeyDown)
            {
                UnityEngine.SceneManagement.SceneManager.LoadScene("SampleScene");
            }
        }
    }
}
