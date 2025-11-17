using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayerCtrl : MonoBehaviour
{
    public int jump_power;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Awake()
    {
        int random_jump = Random.Range(5, 9);
        jump_power = random_jump;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetButton("Jump"))
        {
            GetComponent<Rigidbody>().linearVelocity = new Vector3(0, jump_power, 0);
        }

    }

    void OnCollisionEnter(Collision other)
    {
        SceneManager.LoadScene("SampleScene");
    }
}
