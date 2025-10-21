using UnityEngine;
using UnityEngine.SceneManagement;

public class playerCtrl : MonoBehaviour
{
    private float power;
    public float power_plus = 300.0f;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
    
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButton(0))
        {
            power += power_plus * Time.deltaTime;
        }

        if (Input.GetMouseButtonUp(0))
        {
            this.GetComponent<Rigidbody>().AddForce(new Vector3(power, power, 0));
            power = 0.0f;

        }
        if (this.transform.position.y < -5.0f || Input.GetMouseButtonDown(1))
            SceneManager.LoadScene("SampleScene");
    }
}
